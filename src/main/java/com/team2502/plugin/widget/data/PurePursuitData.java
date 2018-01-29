package com.team2502.plugin.widget.data;

import edu.wpi.first.shuffleboard.api.data.ComplexData;
import edu.wpi.first.shuffleboard.api.util.Maps;
import org.joml.ImmutableVector2f;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.Objects;

/**
 * Represents data from Andrew's Pure Pursuit Implementation
 */
public class PurePursuitData extends ComplexData<PurePursuitData>
{
    private final double[] robot;
    private final double[] circle;
    private final List<ImmutableVector2f> waypoints;

    /**
     * Create a new pure pursuit data object
     *
     * @param robot A double array with length 3 with the following format: [x, y, heading]
     * @param circle A double array with length 3 with the following format: [x, y, radius]
     * @param waypoints A list of waypoints that must be more than 2 long.
     */
    public PurePursuitData(double[] robot, double[] circle, List<ImmutableVector2f> waypoints)
    {
        if(robot.length != 3)
        {
            throw new IllegalArgumentException("robot must be length 3 and of the following format: x,y, heading.");
        }
        else if(circle.length != 3)
        {
            throw new IllegalArgumentException("circle must be length 3 and of the following format: x,y, radius.");
        }
        else if(waypoints.size() < 2)
        {
            throw new IllegalArgumentException("You need more than 2 waypoints!");
        }
        this.robot = robot;
        this.circle = circle;
        this.waypoints = waypoints;
    }

    /**
     * Creates a new differential drive data object from a map.
     *
     * @param map the map to create a data object from
     *
     * @throws java.util.NoSuchElementException if the map is missing any entry
     */
    public static PurePursuitData fromMap(Map<String, Object> map) {
        return new PurePursuitData(
                Maps.get(map, "Robot"),
                Maps.get(map, "Circle"),
                Maps.get(map, "Waypoints")
        );
    }


    @Override
    public Map<String, Object> asMap() {
        return Maps.<String, Object>builder()
                .put("Robot", robot)
                .put("Circle", circle)
                .put("Waypoints", waypoints)
                .build();
    }

    public double[] getRobot()
    {
        return robot;
    }

    public double[] getCircle()
    {
        return circle;
    }

    public List<ImmutableVector2f> getWaypoints()
    {
        return waypoints;
    }

    public PurePursuitData withRobot(double[] robot)
    {
        return new PurePursuitData(robot, circle, waypoints);
    }

    public PurePursuitData withCircle(double[] circle)
    {
        return new PurePursuitData(robot, circle, waypoints);
    }

    public PurePursuitData withWaypoints(List<ImmutableVector2f> waypoints)
    {
        return new PurePursuitData(robot, circle, waypoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurePursuitData that = (PurePursuitData) o;
        return this.robot == that.robot
                && this.circle == that.circle
                && this.waypoints.equals(that.waypoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(robot, circle, waypoints);
    }

    @Override
    public String toString() {
        return String.format("PurePursuitData(robot=%s, circle=%s, waypoints=%s)", Arrays.toString(robot), Arrays.toString(circle), waypoints.toString());
    }
}
