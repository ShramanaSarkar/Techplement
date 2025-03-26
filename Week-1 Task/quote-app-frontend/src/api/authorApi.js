import apiClient from './apiClient';


export const searchAuthors = async (name) => {
  const response = await apiClient.get(`/authors/search?name=${name}`);
  return response.data;
};


export const getListOfAuthors = async (name) => {
  const response = await apiClient.get(`/authors`);
  return response.data;
};
