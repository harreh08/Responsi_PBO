package responsi;

public class MVCInput {
    InputView inputView = new InputView();
    InputModel inputModel = new InputModel();
    InputController inputController = new InputController(inputModel, inputView);
}
