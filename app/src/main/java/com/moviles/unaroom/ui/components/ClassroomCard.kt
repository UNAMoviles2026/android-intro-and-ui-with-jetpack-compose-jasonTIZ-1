package com.moviles.unaroom.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.unaroom.data.Classroom

@Composable
fun ClassroomCard(
    classroom: Classroom,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = classroom.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Capacity: ${classroom.capacity}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Location: ${classroom.location}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

