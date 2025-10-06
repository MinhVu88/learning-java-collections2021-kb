/* Sec 2: Foundations
	2.1 - Interfaces
	2.2 - Collection types
	2.3 - The Collection interface
	2.4 - Collection methods
*/
package com.linkedinlearning.kevinbowersox.sec2.pt_1_4;

public class Main {
	public static void main(String[] args) {
		Contract1 contract = new Implementation();
		printTerms(contract);
	}

	private static void printTerms(Contract1 contract) {
		contract.processTerm1();
		contract.processTerm2();
		contract.processTerm3();
	}
}
