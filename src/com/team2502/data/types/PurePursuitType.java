package com.team2502.data.types;

import com.team2502.data.PurePursuitData;
import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import org.joml.ImmutableVector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class PurePursuitType extends ComplexDataType<PurePursuitData>
{
    public static final PurePursuitType Instance = new PurePursuitType();

    private PurePursuitType()
    {
        super("PurePursuit", PurePursuitData.class);
    }

    @Override
    public Function<Map<String, Object>, PurePursuitData> fromMap()
    {
        return PurePursuitData::fromMap;
    }

    @Override
    public PurePursuitData getDefaultValue()
    {
        //TODO: Make the default make more sense in relation to the UI
        List<ImmutableVector2f> waypoints = new ArrayList<>();
        waypoints.add(new ImmutableVector2f(0, 0));
        waypoints.add(new ImmutableVector2f(10, 10));
        return new PurePursuitData(new double[]{0, 0, 0}, new double[]{0, 0, 0}, waypoints);
    }
}
