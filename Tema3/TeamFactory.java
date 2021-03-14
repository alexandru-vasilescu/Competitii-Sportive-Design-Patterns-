package Tema3;
/**Clasa TeamFactory implementeaza Design Patternurile Factory si Singleton.
 * @author Alexandru Madalin Vasilescu 321CB
 * 
 */
public class TeamFactory {
	/** Atribut de tip TeamFactory(specific Singleton)
	 */
	private static TeamFactory teamFactory;
	/**	Constructor private, folosit doar din interioriul clasei(specific Singleton)
	 */
	private TeamFactory() {
	}
	/** Metoda getInstance(specifica Singleton) care verifica daca exista un Factory si creaza unul daca nu.
	 * @return un teamFactory(existent deja sau creat la apelare)
	 */
	public static TeamFactory getInstance() {
		if (teamFactory==null)
			teamFactory=new TeamFactory();
		return teamFactory;
	}
	/** Metoda createTeam(specifica Factory) primeste un tip de echipa si returneaza o instantiere a tipului de echipa necesar
	 * @param type of team(Football, Basketball, Handball)
	 * @return un nou obiect Team cu tipul specific(FootballTeam,BasketballTeam sau HandballTeam)
	 */
	public Team createTeam(String type) {
		switch(type) {
		case "football":
			return new FootballTeam();
		case "basketball":
			return new BasketballTeam();
		case "handball":
			return new HandballTeam();
		default:
			return null;
		}
	}
}
