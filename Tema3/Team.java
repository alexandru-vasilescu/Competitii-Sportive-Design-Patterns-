package Tema3;

import java.util.ArrayList;
/**Clasa Team este implementata ca in enunt(cu atributele cerute). Aceasta clasa implementeaza interfetele Accepter, Observer si Comparable
 * @author Alexandru Madalin Vasilescu 321CB
 * 
 */
public abstract class Team implements Comparable<Team>, Accepter,Observer {
	private String teamName;
	private String gender;
	private int numberOfPlayers;
	private ArrayList<Player> players=new ArrayList<Player>();
	//Atributul type este folosit pentru a retine ce tip de echipa este, pe langa implementarea directa ca FootballTeam, BasketballTeam, HandballTeam
	private String type;
	//Atributul potizitInClasamanet este folosit pentru a retine locul echipei in clasamanet dupa fiecare meci
	private int pozitieInClasament;
	//Atributul points este folosit pentru a retine numarul de puncte obtinute in urma victoriilor sau egalurilor
	private int points;
	/**Constructor fara parametri, atributele claselor setandu-se prin intermediul getterilor si setterilor
	 */
	public Team() {
	}
	//Getter pentru Pozitia in Clasament a echipei
	public int getPozitieInClasament() {
		return pozitieInClasament;
	}
	//Getter pentru punctele echipei
	public int getPoints() {
		return points;
	}
	/** Metoda folosita in caz de castig al echipei. Aduna 3 puncte la totalul de puncte
	 */
	public void win() {
		points+=3;
	}
	/** Metoda folosita in caz de egal intr-un meci. Aduna un punct la totalul de puncte
	 */
	public void tie() {
		points++;
	}
	//Getter si Setter pentru tipul echipei
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//Getter si Setter pentru numele echipei
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	//Getter si Setter pentru gender
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//Getter si Setter pentru numarul de jucatori
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	//Getter si Setter pentru lista de jucatori
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	/** Metoda care adauga un jucator in lista de jucatori al echipei
	 * @param p este jucatorul citit din fisier si initializat
	 */
	public void addPlayer(Player p) {
		players.add(p);
	}
	/** Implementarea metodei din interfata Observer. Seteaza pozitiaInClasament dupa fiecare meci.
	 * @param index pozitiei in clasamanet
	 */
	@Override
	public void modifyPosition(int index) {
		pozitieInClasament=index;
	}
	/** Implementarea metodei compareTo in functie de numarul de puncte ale echipei. 
	 * 	Implementarea este facuta astfel incat sa se poata sorta arraylistul clasament din clasa Competitie descrescator in functie de numarul de puncte.
	 */
	@Override
	public int compareTo(Team o) {
		if(this.getPoints()<o.getPoints()) return 1;
		else if(this.getPoints()>o.getPoints()) return -1;
		return 0;
	}
	/** Suprascriere a metodei toString pentru a afisa cum este cerut la comanda de "inscriere"
	 */
	@Override
	public String toString() {
		return "{teamName: " + teamName + ", gender: " + gender + ", numberOfPlayers: " + numberOfPlayers
				+ ", players: " + players + "}";
	}
	
}
