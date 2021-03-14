package Tema3;
/**Interfata Visitor contine 3 metode de visit, specifice pentru fiecare tip de echipa(Football, Basketball,Handball)
 * @author Alexandru Madalin Vasilescu 321CB 
 *	
 */
public interface Visitor {
	int visit(FootballTeam team);
	double visit(BasketballTeam team);
	int visit(HandballTeam team);
}
