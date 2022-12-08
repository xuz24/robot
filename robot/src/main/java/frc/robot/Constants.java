// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
    
    public final class DriveConstants{
        public static final int FL_MOTOR =1;
        public static final int FR_MOTOR =2;
        public static final int BL_MOTOR =3;
        public static final int BR_MOTOR =4;
    }

    public final class IOConstants{
        public static final int xBoxController = 5;
    }

    public final class ShooterConstants{
        public static final int TOP_MOTOR = 6;
        public static final int BOTTOM_MOTOR = 7;
    }

    public final class PullerConstants{
        public static final int RIGHT_ARM = 8;
        public static final int LEFT_ARM = 9;
    }
}
