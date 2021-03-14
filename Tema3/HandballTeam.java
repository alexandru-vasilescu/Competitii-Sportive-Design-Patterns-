package Tema3;
/**Clasa extinde Team si este reprezentarea echipei de handbal. Contine constructor si implementarea metodei accept din Desing Patternul Visitor
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public class HandballTeam extends Team implements Accepter {
	public HandballTeam() {
		super();
	}
	@Override
    public double accept(Visitor visitor) {
       return visitor.visit(this);
    }
}
