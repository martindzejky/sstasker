package chuckeles.sstasker.system;

import chuckeles.sstasker.model.Spaceship;
import chuckeles.sstasker.model.Task;

import java.util.ArrayList;

/**
 * Bridge between Java and Javascript.
 */
public class JSBridge {

  //region Methods

  /**
   * Log the text.
   *
   * @param text Text to load
   * @see Log
   */
  public void Log(String text) {
    Log.Instance().Log("[webview] " + text);
  }

  /**
   * Update the spaceship.
   */
  public void Update() {
    Spaceship.Instance().Update();
  }

  /**
   * Exit the application.
   */
  public void Exit() {
    System.exit(0); // TODO: Handle more intelligently
  }

  /**
   * Get the list of tasks.
   *
   * @return Task list
   */
  public ArrayList<Task> GetTaskList() {
    return Spaceship.Instance().GetTasks();
  }

  //endregion

}
