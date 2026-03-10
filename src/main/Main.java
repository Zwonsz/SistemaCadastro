
import controller.Menu;
import formulario.Formulario;
import service.PetController;


void main() {

Formulario form = new Formulario();
form.criarForm();
    PetController petC = new PetController();
    petC.carregarPetsCadastrados();
    Menu menu = new Menu();
    menu.exibirMenu();
    }


