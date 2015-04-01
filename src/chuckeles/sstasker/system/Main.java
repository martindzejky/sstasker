package chuckeles.sstasker.system;

/**
 * Created by Martin on 01.04.2015.
 *
 * This class contains the main method.
 */
public class Main {

  /**
   * Application entry point.
   *
   * @param args Console arguments
   */
  public static void main(String[] args) {

    Log.Instance().Log("SSTasker is starting");

    SSTasker.launch(SSTasker.class, args);

    Log.Instance().Log("SSTasker is ending");

  }

}