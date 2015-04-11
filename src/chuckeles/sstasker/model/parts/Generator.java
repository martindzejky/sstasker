package chuckeles.sstasker.model.parts;

import chuckeles.sstasker.system.Constants;
import chuckeles.sstasker.system.Log;

/**
 * Power generator. Provides power for the spaceship. Produces infinite amount of power as long as it is functional.
 * It has local storage of energy, which is used by most of the parts on the spaceship. If this storage depletes,
 * the parts are using too much energy (or the generator is broken...).
 */
public class Generator extends PartWithHealth {

  //region Methods

  @Override
  public void Update() {
    if (!IsFunctional()) {
      Log.Instance().Log("Generator updated but it is broken," +
          " energy: " + (int)(mEnergy / mMaxEnergy * 100) + "%");
      return;
    }

    super.Update();

    // decrease reliability
    mReliability *= 0.99;

    // generate energy
    mEnergy = Math.min(mMaxEnergy, mEnergy + mGeneration * GetHealth() / Constants.MAX_PART_HEALTH);

    // break apart horribly
    if (Math.random() > mReliability / Constants.MAX_PART_RELIABILITY)
      Break();

    Log.Instance().Log("Generator updated," +
        " reliability: " + (int)(mReliability / Constants.MAX_PART_RELIABILITY * 100) + "%" +
        ", energy: " + (int)(mEnergy / mMaxEnergy * 100) + "%" +
        ", works: " + mWorks);
  }

  @Override
  public void Repair() {
    mWorks = true;
  }

  @Override
  public void Break() {
    mWorks = false; // TODO: Dispatch some sort of event
  }

  /**
   * Substract energy from this generator. Used by other parts that consume energy.
   *
   * @param energy How much to substract
   * @return How much energy was actually substracted
   */
  public double SubstractEnergy(double energy) {
    double e = Math.min(energy, mEnergy);
    mEnergy -= e;

    return e;
  }

  //region Getters

  @Override
  public double GetReliability() {
    return mReliability;
  }

  @Override
  public boolean IsFunctional() {
    return mWorks;
  }

  /**
   * Get the energy level of the generator.
   *
   * @return Energy level
   */
  public double GetEnergy() {
    return mEnergy;
  }

  //endregion

  //endregion

  // ------

  //region Fields

  /**
   * Whether the generator works.
   */
  private boolean mWorks = true;

  /**
   * The generator's reliability.
   *
   * @see Constants#MAX_PART_RELIABILITY
   */
  private double mReliability = Constants.MAX_PART_RELIABILITY * 0.98;

  /**
   * Max energy of the internal buffer.
   */
  private final double mMaxEnergy = 1000.0;

  /**
   * Generator's internal energy buffer.
   */
  private double mEnergy = mMaxEnergy;

  /**
   * Generation base level. How much is generated is also affected by health.
   *
   * @see #mHealth
   */
  private double mGeneration = 200.0;

  //endregion

}