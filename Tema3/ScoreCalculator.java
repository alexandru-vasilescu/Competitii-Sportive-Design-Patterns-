package Tema3;
/**Clasa ScoreCalculator implementeaza interfata Visitor si toate metodele acesteia.
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */	
public class ScoreCalculator implements Visitor {
	/** Prima metoda visit este speciala pentru echipele de Football.
	 *  Se calculeaza score-ul total al echipei,ca suma, cel mai mic score al unui jucator si cel mai mare score al unui jucator.
	 *  La final in functie de gender-ul echipei se adauga minimul sau maximul pentru a avea score-ul cerut de enunt.
	 *  @param team de Football
	 *  @return score-ul total al echipei de tip int
	 */
	@Override
	public int visit(FootballTeam team) {
		int score=0;
		int min,max,aux;
		min=max=team.getPlayers().get(0).getScore();
		for(int i=0;i<team.getNumberOfPlayers();i++) {
			aux=team.getPlayers().get(i).getScore();
			score+=aux;
			if(max<aux)max=aux;
			else if(min>aux) min=aux;
		}
		if(team.getGender().compareTo("masculin")==0){
			score+=max;
		}
		else score+=min;
		return score;
	}
	/** A doua metoda visit este speciala pentru echipele de Basketball.
	 * 	Se calculeaza score-ul total al echipei, ca suma. Se imparte la numarul de jucatori pentru a face media.
	 * 	@param team de Basketball
	 *  @return score-ul total al echipei de tip double (fiind o medie)
	 */
	@Override
	public double visit(BasketballTeam team) {
		double score=0;
		for(int i=0;i<team.getNumberOfPlayers();i++) {
			score+=team.getPlayers().get(i).getScore();
		}
		return score/team.getNumberOfPlayers();
	}
	/**	A treia metoda visit este speciala pentru echipele de Handball.
	 * 	Se calculeaza score-ul total al echipei, suma daca este echipa de baiete, produs daca este echipa de fete.
	 * 	@param team de Handball
	 *  @return score-ul total al echipei de tip int.
	 */
	@Override
	public int visit(HandballTeam team) {
		int score;
		if(team.getGender().compareTo("masculin")==0) score=0;
		else score=1;
		for(int i=0;i<team.getNumberOfPlayers();i++) {
			if(team.getGender().compareTo("masculin")==0)
				score+=team.getPlayers().get(i).getScore();
			else score*=team.getPlayers().get(i).getScore();
		}
		return score;	
	}
	
}
