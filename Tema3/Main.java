package Tema3;

import java.io.*;
import java.util.ArrayList;
/**In clasa Main se deschid fisierele. 
 *	Se citeste din ele si se instantiaza elementele si se apeleaza metodele de afisare corespunzatoare comenzii cerute.
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public class Main {
	/**
	 * Instantiaza o echipa folosind TeamFactory. Se seteaza fiecare atribut folosind Setter
	 * @param line citit din fisier
	 * @return echipa instantiata si cu atributele setate
	 */
	public static Team createTeam(String line) {
		TeamFactory tf=TeamFactory.getInstance();
		String[] words=line.split(", ");
		Team t=tf.createTeam(words[0]);
		t.setType(words[0]);
		t.setTeamName(words[1]);
		t.setGender(words[2]);
		t.setNumberOfPlayers(Integer.parseInt(words[3]));
		return t;
	}
	/**
	 * Instantiaza un player. Se seteaza numele si scoreul folosin Setter
	 * @param line citit din fisier
	 * @return player instantiat si cu atributele setate
	 */
	public static Player createPlayer(String line) {
		Player p=new Player();
		String[] words=line.split(", ");
		p.setName(words[0]);
		p.setScore(Integer.parseInt(words[1]));
		return p;
	}
	public static void main(String[] args) {
		//Lista cu echipe folosita pentru a memora toate echipele citite din fisier
		ArrayList<Team> list=new ArrayList<Team>();
		//readerul este folosit pentru a citi din fisier
		BufferedReader reader=null;
		//String care primeste fiecare linie din fisier pe rand
		String line;
		//In index se retine numarul de echipe din lista
		int index=0;
		//firstPrint se foloseste pentru a vedea daca este prima afisare si a nu afisa un endline
		boolean firstPrint=true;
			try {
				//se deschide primul fisier primit ca parametru de unde se citesc echipele
				reader=new BufferedReader(new FileReader(args[1]));
				//se deschide si fisierul primit ca parametru unde se va afisa. Se seteaza afisarea sa fie facuta in fisier si consola este salvata.
				PrintStream printer=new PrintStream(new File(args[3]));
				PrintStream console=System.out;
				System.setOut(printer);
				//Se citeste din fisier cat timp exista linii
				while(true) {
					//Se citesc datele despre echipa si creaza echipa
					line=reader.readLine();
					if(line==null)
						break;
					list.add(createTeam(line));
					//Se citeste fiecare jucator pe rand, se creaza si se adauga in lista de jucatori a echipei
					for(int i=0;i<list.get(index).getNumberOfPlayers();i++) {
						line=reader.readLine();
						list.get(index).addPlayer(createPlayer(line));
					}
					//Se trece la urmatoarea echipa
					index++;
				}
				//Daca se primeste comanda "inscriere" se afiseaza toate echipele primite
				if(args[0].compareTo("inscriere")==0) 
					for(int i=0;i<index;i++) {
						if(firstPrint==false) System.out.println();
						else firstPrint=false;
						System.out.print(list.get(i));
					}
				//Daca se primeste comanda competitie se stabileste competitia
				if(args[0].compareTo("competitie")==0) {
					//Se inchide reader-ul 
					try {
						reader.close();
					}
					catch(IOException ex) {
						System.out.println("IOEXCEPTION");
						System.exit(1);
					}
					//Se deschide al doilea fisier pentru citire
					reader=new BufferedReader(new FileReader(args[2]));
					//Se citeste prima linie cu detaliile competitiei si se instantiaza competitia si se seteaza atributele ei
					line=reader.readLine();
					String[] words=line.split(", ");
					Competitie competitie=new Competitie();
					competitie.setType(words[0]);
					competitie.setGender(words[1]);
					//Se citesc toate echipele din competitie si se verifica daca echipele sunt bune(ca gender si type)
					while(true) {
						line=reader.readLine();
						if(line==null) 
							break;
						for(int i=0;i<index;i++) {
							if(list.get(i).getTeamName().compareTo(line)==0) {
								if(list.get(i).getGender().compareTo(competitie.getGender())!=0) break;
								if(list.get(i).getType().compareTo(competitie.getType())!=0) break;
								competitie.addTeamCompetitie(list.get(i));
								break;
							}
						}
					}
					//Se apeleaza metoda de jocuri(competitia propriu zisa)
					competitie.jocuri();
					//Se apeleaza metoda de afisare a primelor 3 locuri
					competitie.printPrimeleTrei();
					//Se apeleaza metoda de afisare a tuturor echipelor
					competitie.printEchipe();
				}
				//Se seteaza afisare inapoi in consola
				System.setOut(console);
			}
			catch(FileNotFoundException ex) {
				System.out.println("Nu exista");
				System.exit(1);
			}
			catch(IOException ex) {
				System.out.println("IOException");
				System.exit(1);
			}
			finally {
				//Se inchide fisierul din care s-a citit.
				if(reader!=null)
					try {reader.close();}
					catch(IOException ex) {
						System.out.println("IOEXCEPTION");
						System.exit(1);
					}
			}
		}
	
}
