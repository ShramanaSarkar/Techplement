import React, { useEffect, useState } from 'react';
import { Card, CardContent, TextField, List, ListItem, Typography, Button, Autocomplete } from '@mui/material';
import { getListOfAuthors } from '../api/authorApi';
import { getQuotesByAuthor } from '../api/quoteApi';

const SearchQuotesByAuthor = () => {
  const [authorName, setAuthorName] = useState('');
  const [authorNames, setAuthorNames] = useState([]);
  const [quotes, setQuotes] = useState([]);
  const [error, setError] = useState('');

  // Fetch authors and set names as options
  useEffect(() => {
    const fetchAuthors = async () => {
      try {
        const response = await getListOfAuthors();
        // console.log("Authors fetched:", response);
        const names = response.map(author => author.name);
        setAuthorNames(names);
      } catch (error) {
        console.error('Error fetching authors:', error);
        setError('Failed to load authors. Please try again later.');
      }
    };
    fetchAuthors();
  }, []);

  // Fetch quotes by author
  const fetchQuotesByAuthor = async () => {
    if (!authorName.trim()) {
      setError('Please select a valid author.');
      return;
    }
    setError('');
    try {
      const response = await getQuotesByAuthor(authorName);
      console.log("Quotes fetched:", response);
      setQuotes(response);
      if (response.length === 0) {
        setError('No quotes found for the given author.');
      }
    } catch (error) {
      console.error('Error fetching quotes:', error);
      setError('Failed to fetch quotes. Please try again.');
      setQuotes([]);
    }
  };

  return (
    <Card sx={{ maxWidth: 600, margin: 'auto', marginTop: 4, padding: 2 }}>
      <CardContent>
        <Typography variant="h5" gutterBottom>Search Quotes by Author</Typography>

        <Autocomplete
          options={authorNames}
          value={authorName || ''}
          onInputChange={(event, newValue) => setAuthorName(newValue)}
          renderInput={(params) => (
            <TextField
              {...params}
              label="Select Author"
              variant="outlined"
              fullWidth
            />
          )}
          sx={{ marginBottom: 2 }}
        />

        <Button variant="contained" onClick={fetchQuotesByAuthor} sx={{ marginTop: 2 }}>
          Search Quotes
        </Button>

        {error && <Typography color="error" sx={{ marginTop: 2 }}>{error}</Typography>}

        {quotes.length > 0 && (
          <List sx={{ marginTop: 2 }}>
            {quotes.map((quote) => (
              <ListItem key={quote.id}>
                <Typography>
                  "{quote.content}" - <strong>{quote.author?.name}</strong>
                </Typography>
              </ListItem>
            ))}
          </List>
        )}
      </CardContent>
    </Card>
  );
};

export default SearchQuotesByAuthor;