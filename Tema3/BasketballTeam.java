package Tema3;
/**Clasa extinde Team si este reprezentarea echipei de basket. Contine constructor si implementarea metodei accept din Desing Patternul Visitor
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public class BasketballTeam extends Team implements Accepter{
	public BasketballTeam() {
		super();
	}
	@Override
    public double accept(Visitor visitor) {
       return visitor.visit(this);
    }
}
