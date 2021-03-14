package Tema3;
/**Clasa extinde Team si reprezinta echipa de fotbal. Contine constructor si implementarea functiei accept pentru Design Patternul Visitor
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public class FootballTeam extends Team implements Accepter {
	public FootballTeam() {
		super();
	}
	@Override
    public double accept(Visitor visitor) {
         return visitor.visit(this);
	}
}
