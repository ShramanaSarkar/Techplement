import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';

const QuoteCard = ({ quote }) => {
  return (
    <Card sx={{ marginBottom: '20px', backgroundColor: '#f5f5f5' }}>
      <CardContent>
        <Typography variant="h6" color="text.primary">
          "{quote.content}"
        </Typography>
        <Typography variant="body2" color="text.secondary">
          - {quote.author.name}
        </Typography>
      </CardContent>
    </Card>
  );
};

export default QuoteCard;
