package com.github.clevernucleus.playerex.api.attribute;

import com.github.clevernucleus.playerex.api.util.Maths;
import com.github.clevernucleus.playerex.api.util.TriFunction;

import net.minecraft.util.Identifier;

/**
 * Attribute Function interface, with nested enum Type. Attribute Functions are better explained on the github wiki.
 * 
 * @author CleverNucleus
 *
 */
public interface IAttributeFunction {
	
	/**
	 * Nested Type enum. Contains FLAT and DIMINISHING types that describe how the function should modify its attribute's value.
	 * 
	 * @author CleverNucleus
	 *
	 */
	public enum Type {
		
		/** Adds a + b linearly */
		FLAT((byte)0, (base, value, limit) -> base + value),
		
		/** Adds a + b with a limit l diminishingly. Uses {@link Maths#add(double, double, double)} */
		DIMINISHING((byte)1, Maths::add);
		
		private byte id;
		private TriFunction<Double, Double, Double, Double> func;
		
		private Type(final byte id, final TriFunction<Double, Double, Double, Double> adder) {
			this.id = id;
			this.func = adder;
		}
		
		/**
		 * @param idIn
		 * @return The type from the id. If the id is unknown then defaults to FLAT.
		 */
		public static Type from(final byte idIn) {
			if(idIn == 1) return DIMINISHING;
			else return FLAT;
		}
		
		/**
		 * @return The type's id.
		 */
		public byte id() { return this.id; }
		
		/** Applies the add function of the enum type to the input values (if type is FLAT then limit is irrelevant). */
		public double add(final double base, final double value, final double limit) { return this.func.apply(base, value, limit); }
	}
	
	/**
	 * @return The attribute the function is modifying
	 */
	Identifier attributeKey();
	
	/**
	 * @return The specific enum type of maths that is used to modify the attribute
	 */
	Type type();
	
	/**
	 * @return A multiplier that works as: for every change that occurs how much per unit of that change is also applied to this function's attribute
	 */
	double multiplier();
}
