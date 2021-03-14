package Tema3;
/**Interfata Accepter implementata de cele trei extensii ale clasei Team, contine metoda accept care apeleaza metoda din visitor.
 * @author Alexandru Madalin Vasilescu 321CB
 *	
 */
public interface Accepter {
	double accept(Visitor visitor);
}
