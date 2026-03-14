
import menu.Menu;
import formulario.Formulario;
import repository.PetRepository;


void main() {
    PetRepository petRepository = new PetRepository();
    petRepository.carregarPetsCadastrados();
    Formulario form = new Formulario();
    form.criarForm();
    Menu menu = new Menu(petRepository);
    menu.exibirMenu();
    }


