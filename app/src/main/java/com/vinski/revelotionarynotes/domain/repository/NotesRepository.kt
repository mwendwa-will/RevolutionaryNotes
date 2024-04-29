package com.vinski.revelotionarynotes.domain.repository


import com.vinski.revelotionarynotes.data.remote.dto.CreateNoteDto
import com.vinski.revelotionarynotes.data.remote.dto.UpdateNoteDto
import com.vinski.revelotionarynotes.domain.model.Note
import com.vinski.revelotionarynotes.domain.model.NoteModel
import retrofit2.Response

interface NotesRepository {
    suspend fun getNotes(): Response<List<Note>>? = null
    suspend fun createNote(body: CreateNoteDto): Response<NoteModel>? = null
    suspend fun updateNote(body: UpdateNoteDto, noteId: String): Response<NoteModel>? = null
    suspend fun deleteNote(noteId: String): Response<NoteModel>? = null
}