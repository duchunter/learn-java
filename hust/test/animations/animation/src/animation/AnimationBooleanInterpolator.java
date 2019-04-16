/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package animation;

import javafx.animation.Interpolator;

public class AnimationBooleanInterpolator extends Interpolator {
    @Override
    protected double curve(double t) {
        return Math.abs(0.5-t)*2 ;
    }


}
