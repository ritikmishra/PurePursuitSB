package com.team2502.plugin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.team2502.plugin.widget.PurePursuitWidget;
import com.team2502.plugin.widget.data.PurePursuitData;
import com.team2502.plugin.widget.data.types.PurePursuitType;
import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.data.DataTypes;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.tab.TabInfo;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.widget.LayoutClass;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import java.util.List;
import java.util.Map;

@Description(
        group = "com.team2502.plugin",
        name = "Pure Pursuit",
        version = "0.0.1",
        summary = "Displays what the robot is 'thinking' when it drives using Pure Pursuit."
)
public class PurePursuitPlugin extends Plugin
{
    @Override
    public List<DataType> getDataTypes()
    {
        return ImmutableList.of(PurePursuitType.Instance);
    }

    @Override
    public List<ComponentType> getComponents()
    {
        return ImmutableList.of(WidgetType.forAnnotatedWidget(PurePursuitWidget.class));
    }

    @Override
    public Map<DataType, ComponentType> getDefaultComponents()
    {
        return ImmutableMap.<DataType, ComponentType>builder()
                .put(PurePursuitType.Instance, WidgetType.forAnnotatedWidget(PurePursuitWidget.class))
                .build();
    }
}
