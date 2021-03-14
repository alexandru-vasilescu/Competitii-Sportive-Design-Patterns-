package Tema3;

import java.util.ArrayList;
/**Clasa Competitie este realizata ca in enunt(cu atributele cerute)
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public class Competitie {
	private String type;
	private String gender;
	private ArrayList<Team> teams=new ArrayList<Team>();
	private ArrayList<Team> clasament=new ArrayList<Team>();
	//scoreCalculator este un obiect folosit pentru a accesa Visitor clasa ScoreCalculator implementand interfata Visitor
	private ScoreCalculator scoreCalculator=new ScoreCalculator();
	/** Constructor fara parametri. Atributele clasei se seteaza prin Setteri
	 */
	public Competitie() {
	}
	//Getter si Setter pentru tipul de competitie(Football,Basketball sau Handball)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//Getter si Setter pentru gender(masculin sau feminin)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Metoda folosita pentru a adauga o echipa in lista de echipe din competitie si in clasament.
	 * @param team adaugat
	 */
	public void addTeamCompetitie(Team team) {
		teams.add(team);
		clasament.add(team);
	}
	/**	
	 * Metoda care initializeaza toate meciurile din competitie. Fiecare echipa concureaza cu fiecare echipa doar o data.
	 * Se apeleaza metoda meci. In urma fiecarui meci se sorteaza clasamentul si se notifica Observerul.
	 */
	public void jocuri() {
		//se iau toate echipele de la 0 la numarul de echipe
		for(int i=0;i<teams.size();i++)
			// se confrunta cu toate echipele de la i+1 la numarul de echipe
			for(int j=i+1;j<teams.size();j++) {
				meci(teams.get(i),teams.get(j));
				clasament.sort(null);
				notifyObserver();
			}
	}
	/**
	 *  Metoda notifyObserver ia fiecare echipa din clasament si apeleaza metoda modifyPosition pentru a o instinta de modificarea de pozitie
	 */
	public void notifyObserver() {
		for(int i=0;i<clasament.size();i++) {
			clasament.get(i).modifyPosition(i+1);
		}
	}
	/** Metoda meci primeste 2 echipe. Verifica care are scoreul mai mare si apeleaza metodele necesare pentru a adauga punctele castigate
	 * 
	 * @param t1 prima echipa din meci
	 * @param t2 a doua echipa din meci
	 */
	public void meci(Team t1, Team t2) {
		//daca prima echipa are scoreul mai mare se apeleaza win si primeste 3 puncte
		if(t1.accept(scoreCalculator)>t2.accept(scoreCalculator))
			t1.win();
		//daca au scoreuri egale se apeleaza tie pentru amebele echipe si amandoua echipele primesc un punct
		else if(t1.accept(scoreCalculator)==t2.accept(scoreCalculator)) {
			t1.tie();
			t2.tie();
		}
		//altfel a doua echipa primeste 3 puncte(se apeleaza win)
		else t2.win();
	}
	/**
	 * Se afiseaza podiumul, adica primele 3 echipe din clasament
	 */
	public void printPrimeleTrei() {
		for(int i=0;i<3;i++)
			System.out.println(clasament.get(i).getTeamName());
	}
	/**
	 * Se afiseaza pentru toate echipele in functie de ordinea in care au fost introduse in competitie pozitia ocupata.
	 */
	public void printEchipe() {
		for(int i=0;i<teams.size();i++) {
			System.out.print("Echipa "+teams.get(i).getTeamName()+" a ocupat locul "+ teams.get(i).getPozitieInClasament());
			System.out.println();
		}
	}
}
