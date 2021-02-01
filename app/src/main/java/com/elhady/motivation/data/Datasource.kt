package com.elhady.motivation.data

import com.elhady.motivation.R
import com.elhady.motivation.model.Motivation

class Datasource {
    
    fun loadMotivation() : List<Motivation> {

        return listOf<Motivation>(
            Motivation(R.string.affirmation1,R.drawable.image1),
            Motivation(R.string.affirmation2,R.drawable.image2),
            Motivation(R.string.affirmation3,R.drawable.image3),
            Motivation(R.string.affirmation4,R.drawable.image4),
            Motivation(R.string.affirmation5,R.drawable.image5),
            Motivation(R.string.affirmation6,R.drawable.image6),
            Motivation(R.string.affirmation7,R.drawable.image7),
            Motivation(R.string.affirmation8,R.drawable.image8),
            Motivation(R.string.affirmation9,R.drawable.image9),
            Motivation(R.string.affirmation10,R.drawable.image10))
    }
}