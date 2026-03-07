import service.PetController;
import controller.petController;
import formulario.Formulario;


void main() {

Formulario form = new Formulario();
form.criarForm();
//form.lerForm();
//Menu menu = new Menu();
//menu.exibirMenu();
    PetController pet = new PetController();
    pet.cadastrarPet();
    }


