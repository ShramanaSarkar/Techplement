import apiClient from './apiClient';

export const getQuoteOfTheDay = async () => {
  const response = await apiClient.get('/quotes/quote-of-the-day');
  return response.data;
};

export const getQuotesByAuthor = async (authorName) => {
  const response = await apiClient.get(`/quotes/search?authorName=${authorName}`);
  return response.data;
};


export const addQuote = async (quoteData) => {
  const response = await apiClient.post('/quotes', quoteData);
  return response.data;
};

export const updateQuote = async (id, quoteData) => {
  const response = await apiClient.put(`/quotes/${id}`, quoteData);
  return response.data;
};

export const deleteQuote = async (id) => {
  await apiClient.delete(`/quotes/${id}`);
};
