import React, { useEffect, useState } from 'react';
import { getQuoteOfTheDay } from '../api/quoteApi';
import QuoteCard from '../components/QuoteCard';
import SearchAuthors from '../components/SearchAuthors';
import { Card, CardContent, Typography } from '@mui/material';

const Home = () => {
  const [quote, setQuote] = useState(null);

  useEffect(() => {
    const fetchQuote = async () => {
      const data = await getQuoteOfTheDay();
      setQuote(data);
    };
    fetchQuote();
  }, []);

  return (
    <div>
      <Card sx={{ maxWidth: 600, margin: 'auto', marginTop: 4, padding: 2 }}>
        <CardContent>
          <Typography variant="h4" gutterBottom>Quote of the Day</Typography>
          {
            quote && <QuoteCard quote={quote} />
          }
        </CardContent>
      </Card>
      <SearchAuthors />
    </div>
  );
};

export default Home;