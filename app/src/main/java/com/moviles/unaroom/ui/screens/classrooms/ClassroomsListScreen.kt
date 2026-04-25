package com.moviles.unaroom.ui.screens.classrooms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviles.unaroom.data.Classroom
import com.moviles.unaroom.ui.components.ClassroomCard
import com.moviles.unaroom.ui.theme.UnaRoomTheme

private val mockClassrooms = listOf(
    Classroom(name = "A-101", capacity = 30, location = "Building A"),
    Classroom(name = "B-204", capacity = 45, location = "Building B"),
    Classroom(name = "Lab-3", capacity = 20, location = "Tech Wing"),
    Classroom(name = "C-302", capacity = 60, location = "Building C")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassroomsListScreen(
    classrooms: List<Classroom> = mockClassrooms,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Available Classrooms") }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(classrooms) { classroom ->
                ClassroomCard(classroom = classroom)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ClassroomsListScreenPreview() {
    UnaRoomTheme {
        ClassroomsListScreen()
    }
}
