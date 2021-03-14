package Tema3;
/**Interfata Observer contine doar metoda modifyPosition. Dupa fiecare meci Observer-ul este notificat si in cadrul clasei Team se modifica pozitia.
 * @author Alexandru Madalin Vasilescu
 *	
 */
public interface Observer {
	void modifyPosition(int index);
}
