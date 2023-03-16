package com.ucne.roomexample.ui.ocupacion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.roomexample.data.local.entity.OcupacionEntity
import com.ucne.roomexample.data.remote.dto.OcupacionesDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionListScreen(onNewOcupacion: () -> Unit, viewModel: Ocupaciones2ViewModel = hiltViewModel()) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = { Text("Ocupaciones", style = MaterialTheme.typography.headlineLarge) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onNewOcupacion() }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Save")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        val uiState by viewModel.uiState.collectAsState()
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            OcupacionListBody(uiState.ocupaciones)
        }
    }
}

@Composable
fun OcupacionListBody(ocupacionList: List<OcupacionesDto>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn {
            items(ocupacionList) { ocupacion ->
                OcupacionRow(ocupacion)
            }
        }
    }
}

@Composable
fun OcupacionRow(ocupacion: OcupacionesDto) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        //todo : Implementar swipe to delete


        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = ocupacion.descripcion,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(3f)
            )
            Text(
                String.format("%.2f", ocupacion.sueldo),
                textAlign = TextAlign.End,
                modifier = Modifier.weight(2f)
            )
        }
        Divider(Modifier.fillMaxWidth())
    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun OcupacionListPreview() {
    val ocupacionList = listOf<OcupacionEntity>(
        OcupacionEntity(1, "Programador", 1000.0),
        OcupacionEntity(2, "Diseñador", 2000.0)
    )
    OcupacionListBody(ocupacionList)
}*/
