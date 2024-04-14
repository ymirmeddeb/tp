package seedu.duke.player;

import seedu.duke.Formatter;
import seedu.duke.ui.Ui;
import java.util.Random;

//@@author HenryGan138

public class MediumSkillPlayer extends Player {
    private final int skill = 2;
    public MediumSkillPlayer(String name, int matchCount) {
        super(name, matchCount);
    }

    public MediumSkillPlayer(String name, int matchCount, int power) {
        super(name, matchCount, power);
    }

    @Override
    public void printSelfInfo() {
        super.printSelfInfo();
    }

    @Override
    protected void printPower() {
        int powerLevelTotal = 3;
        System.out.print("Power:");
        for (int i = 0; i < powerLevelTotal; i++){
            if (i < power){
                System.out.print(" ###");
            }else{
                System.out.print("    ");
            }
        }
        if (power == 1){
            System.out.println(" Level-Beginner");
        }else if (power == 2){
            System.out.println(" Level-Medium");
        }else{
            System.out.println(" Level-Expert");
        }
    }

    @Override
    public int getSkill() {
        return skill;
    }

    @Override
    protected void printSkill(){
        int skillLevelTotal = 3;
        System.out.print("Skill:");
        for (int i = 0; i < skillLevelTotal; i++){
            if (i < skill){
                System.out.print(" ###");
            }else{
                System.out.print("    ");
            }
        }
        System.out.println(" Level-Medium");
    }

    @Override
    public void printGoalBeforeShoot() {
        Formatter.printGoalBeforeShotforMedium();
    }

    @Override
    public void printGoalBeforeSave() {
        Formatter.printGoalBeforeSaveForMedium();
    }

    @Override
    public void printGoalAfterShoot(boolean goalScored, int direction) {
        Formatter.printGoalAfterShotMedium(goalScored, direction);
    }
    @Override
    public void upgradePower(int level) {
        assert level>=0&&level<=2;
        this.power = level + 1;
    }

    @Override
    public float shootDirectionAdjust(int dir){
        int mediumMinShoot = 0;
        int mediumMaxShoot = 5;
        if (dir > mediumMaxShoot){
            System.out.println("----------WARNING----------");
            System.out.println("Oops! Remember, medium player could shoot with direction between 0 to 5.");
            System.out.println("You failed to shot on target.");
            System.out.println("Practice makes perfect. Keep playing to unlock more kicks!\"");
            System.out.println("---------------------------");
            int missTargetIndex = -1;
            return this.shootDirectionFormula(missTargetIndex, missTargetIndex, missTargetIndex,this.power);
        }
        int left= Math.max(dir - 1, mediumMinShoot);
        int right= Math.min(dir + 1, mediumMaxShoot);
        return this.shootDirectionFormula(left,right,dir,this.power);
    }

    @Override
    public float shootDirectionFormula(int left, int right, int dir, int power) {
        return super.shootDirectionFormula(left, right, dir, power);
    }

    @Override
    public float aiDirectionAdjust(int aiDir) {
        return (float) (2.5*aiDir);
    }

    @Override
    public float rangeAdjust() {
        float range=0;
        switch (Ui.difficultyLevel){
        case EASY:
            range = (float)0.25;
            break;
        case MEDIUM:
            range = (float)0.5;
            break;
        case HARD:
            range = (float)1.25;
            break;
        default:
            range =0;
        }
        return range;
    }
}
//@@author
