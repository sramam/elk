/*******************************************************************************
 * Copyright (c) 2018, 2020 Kiel University and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.elk.alg.rectpacking.firstiteration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.elk.alg.rectpacking.util.DrawingData;
import org.eclipse.elk.core.math.ElkPadding;

/**
 * This class implements a concrete strategy in the strategy pattern given by {@link BestCandidateFilter}.
 * <p>
 * This class offers a method that filters the given list regarding the aspect ratio. The candidate or candidates with
 * equal aspect ratio that are closest to the desired aspect ratio are returned in the filtered list.
 * </p>
 */
public class AspectRatioFilter implements BestCandidateFilter {

    @Override
    public List<DrawingData> filterList(final List<DrawingData> candidates, final double aspectRatio,
            final ElkPadding padding) {
        List<DrawingData> remainingCandidates = new ArrayList<DrawingData>();
        double smallestDeviation = Double.POSITIVE_INFINITY;
        for (DrawingData opt : candidates) {
            smallestDeviation = Math.min(smallestDeviation,
                    Math.abs(((opt.getDrawingWidth() + padding.getHorizontal())
                            / (opt.getDrawingHeight() + padding.getVertical()))
                        - aspectRatio));
        }
        for (DrawingData candidate : candidates) {
            if (Math.abs(((candidate.getDrawingWidth() + padding.getHorizontal())
                        / (candidate.getDrawingHeight() + padding.getVertical()))
                    - aspectRatio) == smallestDeviation) {
                remainingCandidates.add(candidate);
            }
        }
        return remainingCandidates;
    }
}
