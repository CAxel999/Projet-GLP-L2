package engine.map.roads;

import java.awt.geom.Line2D;

/**
 * Classe qui permet de stocker les différentes limites de la map dans l'ordre droite à gauche de haut en bas.
 * Solitions temporaire?.
 */
public class RoadBoundary {
    //Boundaries inside highway
    public static final Line2D highwayLimit1 = new Line2D.Double(0,80,1800,80);
    public static final Line2D highwayLimit2 = new Line2D.Double(0,160,80,160);
    public static final Line2D highwayLimit3 = new Line2D.Double(200,160,1600, 160);
    public static final Line2D highwayLimit4 = new Line2D.Double(1720,160,1800, 160);



}
