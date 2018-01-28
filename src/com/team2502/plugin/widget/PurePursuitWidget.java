package com.team2502.plugin.widget;

import edu.wpi.first.shuffleboard.api.data.IncompatibleSourceException;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.sources.DataSource;
import edu.wpi.first.shuffleboard.api.widget.AnnotatedWidget;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

import java.util.List;

public class PurePursuitWidget implements AnnotatedWidget
{

    @Override
    public List<? extends Property<?>> getProperties()
    {
        return null;
    }

    @Override
    public Pane getView()
    {
        return null;
    }

    @Override
    public Property<String> titleProperty()
    {
        return null;
    }

    @Override
    public void addSource(DataSource dataSource) throws IncompatibleSourceException
    {

    }

    @Override
    public ObservableList<DataSource> getSources()
    {
        return null;
    }
}
