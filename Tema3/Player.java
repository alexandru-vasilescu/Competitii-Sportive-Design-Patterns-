package Tema3;
/**Clasa Player reprezinta un jucator. Contine campurile de name si score. Campurile sunt setate si accesate prin getter si setter.
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public class Player {
	private String name;
	private int score;
	//constructor fara parametri. Atributele setandu-se cu ajutorul setterilor
	public Player() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/** Am suprascris metoda toString pentru afisarea atributelor unui jucator(comanda de "inscriere")
	 */
	@Override
	public String toString() {
		return "{name: " + name + ", score: " + score + "}";
	}
	
}
