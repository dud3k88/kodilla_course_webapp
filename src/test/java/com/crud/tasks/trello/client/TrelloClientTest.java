package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @Before
    public void init() {
        //given
        Mockito.when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        Mockito.when(trelloConfig.getTrelloUsername()).thenReturn("testuser");
        Mockito.when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        Mockito.when(trelloConfig.getTrelloToken()).thenReturn("test");
    }


    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
            //given
            TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
            trelloBoards[0] = new TrelloBoardDto("test_id", "test_board", new ArrayList<>());

            URI uri = new URI("http://test.com/members/mateuszdudek5/boards?key=test&token=test&fields=name,id&lists=all");

            Mockito.when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(trelloBoards);

            //when
            List<TrelloBoardDto> fetchedTrelloBoards = trelloClient.getTrelloBoards();

            //then
            Assert.assertEquals(1, fetchedTrelloBoards.size());
            Assert.assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
            Assert.assertEquals("test_board", fetchedTrelloBoards.get(0).getName());
            Assert.assertEquals(new ArrayList<>(), fetchedTrelloBoards.get(0).getLists());
        }
    }
