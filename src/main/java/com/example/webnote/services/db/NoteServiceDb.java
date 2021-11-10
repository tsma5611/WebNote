package com.example.webnote.services.db;

import com.example.webnote.repos.NoteRepository;
import com.example.webnote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceDb implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

}
