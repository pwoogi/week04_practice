package com.sparta.week04_practice.service;

import com.sparta.week04_practice.model.Note;
import com.sparta.week04_practice.model.User;
import com.sparta.week04_practice.model.UserNotFoundException;
import com.sparta.week04_practice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    /**
     * 노트 조회
     * 유저는 본인의 노트만 조회할 수 있다.
     * 어드민은 모든 노트를 조회할 수 있다.
     */
    @Transactional(readOnly = true)
    public List<Note> findByUser(User user) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (user.isAdmin()) {
            return noteRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        }
        return noteRepository.findByUserOrderByIdDesc(user);
    }

    /**
     * 노트 저장
     */
    public Note saveNote(User user, String title, String content) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        return noteRepository.save(new Note(title, content, user));
    }

    /**
     * 노트 삭제
     */
    public void deleteNote(User user, Long noteId) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        Note note = noteRepository.findByIdAndUser(noteId, user);
        if (note != null) {
            noteRepository.delete(note);
        }
    }
}
