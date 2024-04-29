
package com.vinski.revelotionarynotes.data.repository


import com.vinski.revelotionarynotes.data.remote.NotesApi
import com.vinski.revelotionarynotes.data.remote.dto.CreateNoteDto
import com.vinski.revelotionarynotes.data.remote.dto.UpdateNoteDto
import com.vinski.revelotionarynotes.domain.model.Note
import com.vinski.revelotionarynotes.domain.model.NoteModel
import com.vinski.revelotionarynotes.domain.repository.NotesRepository
import retrofit2.Response

import javax.inject.Inject

class NotesRepositoryImp @Inject constructor(private val api: NotesApi) : NotesRepository {
    override suspend fun getNotes(): Response<List<Note>> {
        return api.getNotes()
    }

    override suspend fun createNote(body: CreateNoteDto): Response<NoteModel> {
        return api.createNote(body)
    }

    override suspend fun updateNote(body: UpdateNoteDto, noteId: String): Response<NoteModel> {
        return api.updateNote(noteId, body)
    }

    override suspend fun deleteNote(noteId: String): Response<NoteModel> {
        return api.deleteNote(noteId)
    }
}