package com.example.demo.Controller;

import com.example.demo.Service.BooksService;
import com.example.demo.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class NotesControllerTest {

    @InjectMocks
    NotesController notesController;

    @Mock
    BooksService booksService;

    MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(notesController).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBook_Ok() throws Exception {

        Book book  = new Book();
        book.setName("Demo");
        book.setDescription("Demo");


        when(booksService.findBookById(anyLong())).thenReturn(book);
        MvcResult result = mockMvc.perform(get("/findBook/{id}").contentType(MediaType.APPLICATION_JSON).content(String.valueOf(123))).andExpect(status().isOk()).andReturn();

    }

}
