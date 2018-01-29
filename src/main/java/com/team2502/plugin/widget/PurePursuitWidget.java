package com.team2502.plugin.widget;

import com.team2502.plugin.widget.data.PurePursuitData;
import com.team2502.plugin.widget.data.types.PurePursuitType;
import edu.wpi.first.shuffleboard.api.data.IncompatibleSourceException;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.sources.DataSource;
import edu.wpi.first.shuffleboard.api.widget.AnnotatedWidget;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import org.fxmisc.easybind.EasyBind;

import java.util.List;

@Description(name = "Pure Pursuit Visualizer", dataTypes = PurePursuitData.class)
@ParametrizedController("PurePursuitWidget.fxml")
public class PurePursuitWidget extends SimpleAnnotatedWidget<PurePursuitData>
{
    @FXML
    private Rectangle robot;

    @FXML
    private AnchorPane root;

    @FXML
    private Circle circle;

    @FXML
    private Line line;

    @FXML
    private Path waypoints;

    private boolean display_circle = true;

    @FXML
    private void initialize()
    {
        System.out.println(dataProperty().toString());
//        robot.xProperty().bind(
//                Bindings.createObjectBinding(
//                () -> createSolidColorBackground(getColor()),
//                dataProperty(), trueColor, falseColor));
//        circle.visibleProperty().bind(EasyBind.map(dataProperty(), d -> d).orElse(false));
//        line.visibleProperty().bind(circle.visibleProperty().not());


    }

    @Override
    public Pane getView()
    {
        return root;

    }

    private void adjustRobotRectangle(double[] robot_data)
    {
        robot.setX(robot_data[0]);
        robot.setY(robot_data[1]);

        robot.setRotate(-1 * radiansToDegrees(robot_data[2]));
    }

    private void adjustCircle(double[] circle_data, double[] robot_data)
    {
        if(circle_data[2] > 1000)
        {
            display_circle = false;
            line.setStartX(robot_data[0]);
            line.setStartY(robot_data[1]);
//            line.


        }
        else
        {
            display_circle = true;
            circle.setCenterX(circle_data[0]);
            circle.setCenterY(circle_data[1]);
            circle.setRadius(circle_data[2]);
        }


    }

    private double radiansToDegrees(double radians)
    {
        return radians * 180 / Math.PI;
    }
}
