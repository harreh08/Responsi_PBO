package responsi;

public class MVCUpdate {
    UpdateView updateView = new UpdateView();
    UpdateModel updateModel = new UpdateModel();
    UpdateController updateController = new UpdateController(updateModel, updateView);
}
