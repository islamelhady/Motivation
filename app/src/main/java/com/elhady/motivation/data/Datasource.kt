package com.elhady.motivation.data

import com.elhady.motivation.R
import com.elhady.motivation.model.Motivation

class Datasource {
    
    fun loadMotivation() : List<Motivation> {

        return listOf<Motivation>(
            Motivation(R.string.affirmation1),
            Motivation(R.string.affirmation2),
            Motivation(R.string.affirmation3),
            Motivation(R.string.affirmation4),
            Motivation(R.string.affirmation5),
            Motivation(R.string.affirmation6),
            Motivation(R.string.affirmation7),
            Motivation(R.string.affirmation8),
            Motivation(R.string.affirmation9),
            Motivation(R.string.affirmation10))
    }
}