package chuckeles.sstasker.model;

import java.util.ArrayList;

/**
 * The main model of our spaceship. Singleton. Contains the list of tasks, crew members and inventory items.
 */
public class Spaceship {

  private Spaceship() {
    mTasks.add(new Task("Opravit motor"));
    mTasks.add(new Task("Opravit povrch"));
  }

  // ------

  /**
   * Get singleton instance.
   *
   * @return Singleton instance
   */
  public static Spaceship Instance() {
    if (mInstance == null)
      mInstance = new Spaceship();

    return mInstance;
  }

  /**
   * Get the list of tasks.
   *
   * @return The list of tasks
   */
  public ArrayList<Task> GetTasks() {
    return mTasks;
  }

  /**
   * Get the spaceship crew.
   *
   * @return The list of crew members
   */
  public ArrayList<Cosmonaut> GetCrew() {
    return mCrew;
  }

  // ------

  /**
   * The singleton instance.
   */
  private static Spaceship mInstance;

  /**
   * The list of tasks.
   */
  private ArrayList<Task> mTasks = new ArrayList<>();

  /**
   * The list of crew members.
   */
  private ArrayList<Cosmonaut> mCrew = new ArrayList<>();
}
