package com.example.todolistcompose

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolistcompose.db.Note
import com.example.todolistcompose.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val  viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items by viewModel.getAllNotes().observeAsState(arrayListOf())
//            var openDialog by remember { mutableStateOf(false) }
//            var textTitle = remember {
//                mutableStateOf("")
//            }
//
//
//            var textContent=remember{
//                mutableStateOf("")
//            }

            Box(Modifier.fillMaxSize()) {
                LazyColumn() {
                    items(items = items) { note ->
                        NoteItem(note = note){
                            val intent=Intent(this@MainActivity,EditNoteActivity::class.java).also {
                                it.putExtra("noteId",note.id)
                                startActivity(it)
                            }
                        }
                    }
                }
                FloatingActionButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(12.dp),
                    onClick = {
                        //openDialog = true
                        val intent=Intent(this@MainActivity,AddNoteActivity::class.java).also {
                            startActivity(it)
                        }

                    }) {
                    Text("+")
                }

//                if (openDialog) {
//                    AlertDialog(onDismissRequest = {
//                        openDialog = false
//                    }, title = { Text("Add Note") },
//                        text = {
//                            Column() {
//                                OutlinedTextField(
//                                    value = textTitle.value,
//                                    label = { Text(text = "Title")},
//                                    onValueChange = {
//                                        textTitle.value = it
//                                    }
//                                )
//                                OutlinedTextField(
//                                    value = textContent.value,
//                                    label = { Text(text = "Content")},
//                                    onValueChange = {
//                                        textContent.value = it
//                                    },
//                                    maxLines = 3,
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(100.dp)
//
//                                )
//                            }
//                        },
//
//                        confirmButton = {
//                            Button(onClick = {
//                                Log.d("TAG", "onCreateTItle: ${textTitle.value}")
//                                Log.d("TAG", "onCreateContent: ${textContent.value}")
//                                viewModel.insertNote(Note(textTitle.value,textContent.value))
//                                openDialog=false
//                                Toast.makeText(this@MainActivity, "Note Added", Toast.LENGTH_SHORT)
//                                    .show()
//                            }) {
//                                Text("Yes")
//
//                            }
//                        }, dismissButton = {
//                            Button(onClick = { openDialog = false }) {
//                                Text("No")
//                            }
//                        }, modifier = Modifier
//                            .padding(1.dp)
//                            .wrapContentHeight())
//                }
            }

        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SingleItem(note: Note,onCLickNote:()->Unit) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .height(90.dp), shape = RoundedCornerShape(5.dp),
        onClick = onCLickNote
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Text(text = note.title, modifier = Modifier.padding(5.dp))
            Text(text = note.content)

        }
    }

}

