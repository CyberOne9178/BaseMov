package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hub_ID {
    private static String currentGameData = "R"; 

    public static Alliance getActiveAlliance() {
        double currentTime = DriverStation.getMatchTime();
        if (currentTime < 0) currentTime = 135; // Padrão para simulação

        String dsData = DriverStation.getGameSpecificMessage();
        if (dsData != null && !dsData.isEmpty()) currentGameData = dsData;

        Alliance initialAlliance = (currentGameData.startsWith("R")) ? Alliance.Red : Alliance.Blue;

        // Mesma lógica de janelas que você já usa
        if (currentTime >= 130 || currentTime < 30) return DriverStation.getAlliance().orElse(Alliance.Blue);
        else if (currentTime >= 105 || (currentTime < 80 && currentTime >= 55)) {
            return (initialAlliance == Alliance.Red) ? Alliance.Blue : Alliance.Red;
        } 
        else return initialAlliance;
    }

    /**
     * Calcula quanto tempo falta para a próxima transição do Hub.
     */
    public static double getTimeToNextChange() {
        double currentTime = DriverStation.getMatchTime();
        if (currentTime < 0) return 0;

        // Verifica qual é o próximo marco de tempo
        if (currentTime > 130) return currentTime - 130;
        if (currentTime > 105) return currentTime - 105;
        if (currentTime > 80)  return currentTime - 80;
        if (currentTime > 55)  return currentTime - 55;
        if (currentTime > 30)  return currentTime - 30;
        
        return 0; // Já passou da última troca
    }

    public static void logToDashboard() {
        SmartDashboard.putBoolean("Hub Ativo para Nós", isAllianceHubActive());
        SmartDashboard.putNumber("Tempo Restante", DriverStation.getMatchTime());
        
        // NOVO: Envia o cronômetro regressivo para a troca
        SmartDashboard.putNumber("Tempo para Troca", getTimeToNextChange());
        
        // Opcional: Mostra um aviso visual se faltar menos de 5 segundos
        SmartDashboard.putBoolean("Alerta Troca Proxima", getTimeToNextChange() < 5 && getTimeToNextChange() > 0);
    }

    public static boolean isAllianceHubActive() {
        Alliance active = getActiveAlliance();
        return active != null && active == DriverStation.getAlliance().orElse(Alliance.Blue);
    }
}