package task;

public class Alchemist extends BattleUnitBase{
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int healthMin=100000;
        int healthMax = 0;
        BattleUnit playerMin= ownTeam[0];
        BattleUnit playerMax= ownTeam[0];
        for(int i=0; i<ownTeam.length;i++){
            if(ownTeam[i].health() < healthMin && ownTeam[i].health() > 0){
                healthMin = ownTeam[i].health();
                playerMin = ownTeam[i];
            }
            else if(ownTeam[i].health() > healthMax && ownTeam[i].health() > 0){
                healthMax = ownTeam[i].health();
                playerMax = ownTeam[i];
            }
        }
        playerMin.heal(10);
        playerMax.setStrength(playerMax.strength()+1);
    }
    public void attack(BattleUnit other){
        other.setStrength(other.strength()-2);
        other.setMaxHealth(other.maxHealth()-4);
    }
}
